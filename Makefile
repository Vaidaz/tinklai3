build:
	javac -d bin/ src/*.java
clear:
	rm bin/*.class
run:
	java -cp bin/ DistanceVector
t:
	@make build -s
	@make run -s