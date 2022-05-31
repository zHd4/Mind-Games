install-dist:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app

build-run-dist:
	./gradlew build
	./gradlew installDist
	./build/install/app/bin/app
