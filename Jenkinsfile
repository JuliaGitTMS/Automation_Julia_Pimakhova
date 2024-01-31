pipeline {
    agent any

    tools {
        maven "M3"
    }
    stages {
        stage('Project build') {
            steps {
                bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('Tests') {
            steps {
                bat 'mvn test -Dsuite=%SUITE% -Dconfig=%CONFIG%'
            }
        }
        stage('Log') {
            steps {
                archiveArtifacts artifacts: 'target/logs/*', followSymlinks: false
            }
        }
    }
    post ('Allure report') {
        // success, failure, always
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}

