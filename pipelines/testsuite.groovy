pipeline {
    agent any
 
    stages {
        stage('Test') {
            steps {
                bat "echo %M2_HOME%"
                bat "echo %PATH%"
                
                waitUntil(5){
                    script{
                        def returnVal = bat(script: "mvn spring-boot:run", returnStdout: true)
                        return (returnVal == 0)
                    }
                }
                bat "mvn -D clean test"
            }
 
            post {                
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/', 
                       reportFiles: 'emailable-report.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
            }
        }
    }
}
