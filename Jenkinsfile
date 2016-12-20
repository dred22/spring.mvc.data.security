stage "tests"
node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'mvn clean verify -Pdev-test'
		junit '**/target/surefire-reports/*.xml'

	}
}
stage "deploy configm"
timeout(time:1, unit:'HOURS'){
	input "Do you confirm?"
}

stage "deploy"
node{
	checkout scm
	withEnv(["PATH+MVN=${tool 'MVN'}/bin"]){
		sh 'mvn clean tomcat7:deploy -DskipTests -Pprod'

	}
}
