node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'mvn clean verify -Pdev-test'
		junit '**/target/surefire-reports/*.xml'

	}
}
