library("jsonlite", quietly=T, verbose=F, warn.conflicts=FALSE)
library("ggplot2",quietly=T, verbose=F, warn.conflicts=FALSE)
library("plyr", quietly=T, verbose=F, warn.conflicts=FALSE)
source("functions.R")
source("plot.R")
source("constants.R")


results <-read.csv(resultsPath, header=TRUE, sep='\t')

config <- fromJSON(configPath)

if (validPhase(results, config$Summarize_Functions$Phases) == FALSE){
  print("Non existing phasename was given!")
  quit()
}

for(row in 1:nrow(config$Summarize_Functions)){
  if (validMetric(results, config$Summarize_Functions[row,]$Metric) == FALSE){
    print("Non existing metricname was given!")
    quit()
  }
}
  
  
index <- 0
settings <- PlotSettings()
uniqueScenarios <- unique(results$ChangeSet)
createFolders(rootPath, uniqueScenarios)

for(row in 1:nrow(config$Summarize_Functions)){
  phases <- config$Summarize_Functions[row,]$Phases
  index <- index + 1
  for(scenario in uniqueScenarios){
    metric <- config$Summarize_Functions[row,]$Metric
    subData1 <- subset(results, ChangeSet==scenario & MetricName == metric)
    subData1$MetricValue <- subData1$MetricValue * (10** config$Summarize_Functions[row,]$Y_Axis_Scale)
    path <- paste(rootPath, scenario, "/", sep='')
    
    if (config$Dimensions$Groups$Query){
      uniqueTools <- unique(subData1$Tool)
      settings <- setGroup(settings, "Query")
      for(tool in uniqueTools){
        subData2 <- subset(subData1, Tool==tool)
        
        if (config$Dimensions$X_Dimensions$Size){
          title <- paste(tool, ",", scenario, ", Function: ", concatPhases(phases), " (Y: Log10) (X: Log10)", sep='')
         
          settings <- setTitle(settings, title)
          settings <- setDimensions(settings, "Size", "MetricValue")
          settings <- setLabels(settings, "Size", config$Summarize_Functions[row,]$Y_Label)
          settings <- setAxis(settings, "Log10", yAxis)
          for (extension in config$Extension){
            fileName <- paste(path,scenario, "-", tool, "-GroupBy-Query-",metric, "-Function", index, ".", 
                              extension, sep='')
            savePlot(subData2, settings, phases, fileName)
          }
        }
        
        if (config$Dimensions$X_Dimensions$Iteration){
          uniqueSizes <-unique(subData2$Size)
          for(size in uniqueSizes){
            subData3 <- subset(subData2, Size==size)
            title <- paste(scenario, ", ", tool, ", Size: ", size, ", Function: ", concatPhases(phases), 
                           " (Y: Log10) (X: Continuous)", sep='')
           
            settings <- setTitle(settings, title)
            settings <- setDimensions(settings, "Iteration", "MetricValue")
            settings <- setLabels(settings, "Iterations", config$Summarize_Functions[row,]$Y_Label)
            settings <- setAxis(settings, "Continuous", yAxis)
            for (extension in config$Extension){
              fileName <- paste(path,scenario, "-", tool, "-Size", size, "-GroupBy-Query-",metric, "-Function", index, ".",
                                extension, sep='')
              savePlot(subData3, settings, phases, fileName)
            }
          }
        } 
      }
    }
    
    if (config$Dimensions$Groups$Tool){
      uniqueQueries <- unique(subData1$Query)
      settings <- setGroup(settings, "Tool")
      for(query in uniqueQueries){
        subData2 <- subset(subData1, Query==query)
        
        if (config$Dimensions$X_Dimensions$Size){
          title <- paste(scenario, ", ",query, ", Function: : ", concatPhases(phases), " (Y: Log10) (X: Log10)", sep='')
          settings <- setTitle(settings, title)
          settings <- setDimensions(settings, "Size", "MetricValue")
          settings <- setLabels(settings, "Size", config$Summarize_Functions[row,]$Y_Label)
          settings <- setAxis(settings, "Log10", yAxis)
          for (extension in config$Extension){
            fileName <- paste(path,scenario, "-", query, "-GroupBy-Tool-",metric, "-Function", index, ".", 
                              extension, sep='')
            savePlot(subData2, settings, phases, fileName)
          }
        }
        
        if (config$Dimensions$X_Dimensions$Iteration){
          uniqueSizes <-unique(subData2$Size)
          settings <- setDimensions(settings, "Iteration", "MetricValue")
          settings <- setLabels(settings, "Iterations", config$Summarize_Functions[row,]$Y_Label)
          settings <- setAxis(settings, "Continuous", yAxis)
          for(size in uniqueSizes){
            subData3 <- subset(subData2, Size==size)
            title <- paste(scenario, ", ", query, ", Size: ", size, ", Function:  ", concatPhases(phases),
                           " (Y: Log10) (X: Continuous)", sep='')
            for (extension in config$Extension){
              fileName <- paste(path,scenario, "-", query, "-Size", size, "-GroupBy-Tool-",metric, "-Function", index, ".", 
                                extension, sep='')
              settings <- setTitle(settings, title)
              savePlot(subData3, settings, phases, fileName)
            }
          }
        }     
      }
    }
  }
}