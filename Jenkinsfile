pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }

    stages {
        stage('Build') {
            steps {
                sh './mvnw install'
            }
        }
        stage('Docker') {
            steps {
                sh 'docker build -t weatherapp:v1 .'
            }
        }
    }
}