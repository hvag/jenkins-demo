job('NodeJS Docker example') {

    scm {
        git('https://github.com/hmashaw/docker-node-jenkins.git') {  node ->
            node / gitConfigName('HVAG Tester')
            node / gitConfigEmail('tester@hvadvisorygroup.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('markshaw/docker-node-jenkins-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }

}
