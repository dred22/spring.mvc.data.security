node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'mvn clean verify'

	}
}
