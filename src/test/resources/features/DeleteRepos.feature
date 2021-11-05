Feature: Delete repository

  Scenario: Get list of repositories parse name of repository and delete it
    #* User gets list of repositories "users/EVZaykov/repos" and saves response to var "responseListOfRepositories"
    #* User gets value from JsonPath "[0].name" from response "responseListOfRepositories" and saves to var "nameOfRepos"
    * User deletes repository with name "12324" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "EVZ" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "EVZ1" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "1234" and saves response to var "responseAfterDeleting"