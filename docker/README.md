# Selenium docker grid

The docker compose file in this folder can be used to spin up a selenium docker grid. The command to be used is:

	docker-compose up -d
	
If you want to scale the number of nodes you can use for example:

	docker-compose scale chromenode=3
	
To stop & remove the containers you can use:

	docker-compose stop
	docker-compose rm
	
Or just plainly use:

	docker-compose down
