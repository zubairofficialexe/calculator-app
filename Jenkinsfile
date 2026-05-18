pipeline {
agent any

environment {
    IMAGE_NAME = "zubairzone/calculator-app"
    IMAGE_TAG = "v.01"
}

stages {

    stage('Clone Repository') {
        steps {
            git 'https://github.com/zubairofficialexe/calculator-app.git'
        }
    }

    stage('Build Maven') {
        steps {
            bat 'mvn clean package'
        }
    }

    stage('Build Docker Image') {
        steps {
            bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
        }
    }

   stage('Docker Login') {
    steps {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            powershell '''
                $ErrorActionPreference = "Stop"
                $pass = $env:DOCKER_PASS.Trim()
                $pass | docker login --username $env:DOCKER_USER --password-stdin
            '''
        }
    }
}

    stage('Push Docker Image') {
        steps {
            bat 'docker push %IMAGE_NAME%:%IMAGE_TAG%'
        }
    }
}


}
