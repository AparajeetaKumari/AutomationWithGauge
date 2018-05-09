# AutomationWithGauge
Automation with Gauge Framework

#The following command installs Gauge on MacOS.
brew update
brew install gauge

# Download and Install IDE Intellij
# Import the project on IDE 

# Run the specification on IDE
Right click on the spec file and click on "Run search.spec" 

#Run specification from command line.
gauge run specs folder location


#To execute all the specs and scenarios which are labelled with certain tags
gauge run --tags tag1,tag2 specs

#For parallel execution
gauge run --parallel specs

#Adding implementation for new scenarios added in the specification file.
Click on the step and select add implementation .
Implementation can be added in the existing file or a new file can be created.






