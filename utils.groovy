
def extendEnv(env) {
  env.FOO = 1
}

def checkoutRepo(devRepo, prodRepo) {
  checkout([
    $class:'GitSCM',
    branches: [[name: 'master']],
    extensions: [[$class: 'WipeWorkspace']],
    userRemoteConfigs: [
      [credentialsId: 'github-afrobot', url: "${devRepo}",  name: 'origin'],
      [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod']
    ]])
}
