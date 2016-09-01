def extendEnv() {
  env.GIT_HEAD        = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
  env.GIT_DEV_MASTER  = sh(returnStdout: true, script: 'git rev-parse origin/master').trim()
  env.GIT.DEV_URL     = sh(returnStdout: true, script: 'git config --get remote.origin.url').replace()
  env.GIT_PROD_MASTER = sh(returnStdout: true, script: 'git rev-parse origin/master').trim()
}

def checkoutRepo(devRepo, prodRepo) {
  checkout([
    $class:'GitSCM',
    branches: [[name: 'master']],
    extensions: [[$class: 'WipeWorkspace']],
    userRemoteConfigs: [
      [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
    ]])

  checkout scm
}

this
