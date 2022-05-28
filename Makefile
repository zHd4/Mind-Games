clean:
	./gradlew clean

build:
	./gradlew build

install:
	./gradlew install

install-dist:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

update-deps:
	./gradlew useLatestVersions

build-run: build run
