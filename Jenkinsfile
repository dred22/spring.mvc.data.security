node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'mvn verify'
		junit '**/target/surefire-reports/*.xml
	}
}
