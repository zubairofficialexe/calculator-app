pipeline {

    agent any

    environment {

        IMAGE_NAME = "zubairzone/calculator-app"
    }

    stages {

        stage('Clone Repository') {

            steps {

                git 'YOUR_GITHUB_REPO_URL'
            }
        }

        stage('Build Maven') {

            steps {

                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {

            steps {

                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Push Docker Image') {

            steps {

                sh 'docker push $IMAGE_NAME'
            }
        }

        
    }
}git