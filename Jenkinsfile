pipeline {
agent any

```
environment {
    IMAGE_NAME = "zubairzone/calculator-app"
    IMAGE_TAG  = "v.01"
}

stages {

    stage('Clone Repository') {
        steps {
            git 'https://github.com/zubairofficialexe/calculator-app.git'
        }
    }

    stage('Build Maven') {
        steps {
            sh 'mvn clean package'
        }
    }

    stage('Build Docker Image') {
        steps {
            sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
        }
    }

    stage('Docker Login') {
        steps {
            withCredentials([usernamePassword(
                credentialsId: 'dockerhub',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS'
            )]) {

                sh 'echo "$DOCKER_PASS" | docker login --username "$DOCKER_USER" --password-stdin'
            }
        }
    }

    stage('Push Docker Image') {
        steps {
            sh 'docker push $IMAGE_NAME:$IMAGE_TAG'
        }
    }
}
```

}
