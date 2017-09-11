job('NodeJS example') {

    scm {
        git('https://github.com/hvag/jenkins-demo.git') {  node ->
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
        shell("npm install")
    }

}
