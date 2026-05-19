pipeline {
agent any

environment {
    IMAGE_NAME = "zubairzone/calculator-app"
    IMAGE_TAG  = "v.03"
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

    stage('Push Docker Image') {
        steps {
            bat 'docker push %IMAGE_NAME%:%IMAGE_TAG%'
        }
    }
}


}
