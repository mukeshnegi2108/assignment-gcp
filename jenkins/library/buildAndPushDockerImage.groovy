def call(String dockerfilePath, String imageName, String gcrRegistry) {
    stage("Build Docker Image") {
        sh "docker build -t ${imageName} -f ${dockerfilePath} ."
        sh "docker tag ${imageName} ${gcrRegistry}/${imageName}"
        sh "docker push ${gcrRegistry}/${imageName}"
    }
}
