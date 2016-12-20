node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'mvn verify'
		sh 'ls target'
		junit 'target/surefire-reports/*.xml'
	}
}
