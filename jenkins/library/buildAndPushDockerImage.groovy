def buildDockerImage(String dockerfilePath, String imageName, String gcrRegistry) {
    stage("Build Docker Image") {
        // Retrieve Google Cloud credentials
        withCredentials([googleServiceAccount(credentialsId: 'GoogleAuthenticator')]) {
             def googleCredentialsKeyfileJson = credentials('GoogleAuthenticator')

            sh "gcloud auth activate-service-account --key-file=${googleCredentialsKeyfileJson}"
            sh "gcloud config set project ${googleProjectId}"
        }

        // Build Docker image
        sh "docker build -t ${imageName} -f ${dockerfilePath} ."
        
        // Tag the image with the GCR registry URL
        sh "docker tag ${imageName} ${gcrRegistry}/${imageName}"
        
        // Push the image to GCR
        sh "docker push ${gcrRegistry}/${imageName}"
    }
}