## Installing dependencies
### Docker
#### Mac
1. Install using Docker. In the terminal, type:
    ```
    brew cask install docker
    ```
2. Start the Docker app
#### Other OS
1. Go to https://docs.docker.com/install/ for instructions to install Docker
2. Start the Docker app

## Running the REST API
1. In the terminal, navigate to the restapi-folder
2. Type:
    ```bash
    docker-compose up -d
    ```
3. The REST API should now be up and running and available on `http://0.0.0.0:8080/`. You can test by pasting this
 url in the browser: http://0.0.0.0:8080/users. If you retrieve one user, everything works

## REST API documention:
Initially, there is one user in the database with the username `boligsoker`

### Getting filter for a user
#### Request
`GET /{username}/filter`
#### Sample success response
200
```json
{
    "user_id": 1,
    "area": null,
    "min_total_price": null,
    "max_total_price": null,
    "min_size": null,
    "max_size": null,
    "n_bedrooms": null,
    "owner_type": null
}
```


### Updating filter for a user
#### Request
`PUT /{username}/filter`
#### Sample body
```json
{
    "user_id": 1,
    "area": null,
    "min_total_price": null,
    "max_total_price": null,
    "min_size": null,
    "max_size": null,
    "n_bedrooms": null,
    "owner_type": null
}
```
#### Success response
`200`
