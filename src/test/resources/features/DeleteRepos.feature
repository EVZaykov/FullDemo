Feature: Delete repository

  Scenario: Get list of repositories parse name of repository and delete it

    #* User gets list of repositories "users/EVZaykov/repos" and saves response to var "responseListOfRepositories"
    #* User gets value from JsonPath "[0].name" from response "responseListOfRepositories" and saves to var "nameOfRepos"
    * User deletes repository with name "10" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "3 " and saves response to var "responseAfterDeleting"
    * User deletes repository with name "4" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "7" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "8 " and saves response to var "responseAfterDeleting"
    * User deletes repository with name "9  " and saves response to var "responseAfterDeleting"
    * User deletes repository with name "11" and saves response to var "responseAfterDeleting"
    * User deletes repository with name "1111111" and saves response to var "responseAfterDeleting"
      #* User creates repository with name "FromGit" and saves response to var "responseAfterCreating"
  #* User gets value from JsonPath "name" from response "responseAfterCreating" and saves to var "nameOfRepos"
    #* User gets response "responseAfterCreating" and checks status code ER "201"
    #* User gets value from JsonPath "name" from response "responseAfterCreating" and saves to var "nameOfRepos"
    #* User checks all params in response "responseAfterCreating"
     # | full_name | EVZaykov/${nameOfRepos}                                            |
     # | url       | https://api.github.com/repos/EVZaykov/${nameOfRepos}               |
     # | keys_url  | https://api.github.com/repos/EVZaykov/${nameOfRepos}/keys{/key_id} |



    #* User gets list of repositories "users/EVZaykov/repos" and saves response to var "responseListOfRepositories"
    #* User gets value from JsonPath "[0].name" from response "responseListOfRepositories" and saves to var "nameOfRepos"

    #* User gets response "responseListOfRepositories" and checks value form JsonPath "name" ER "EV1333"
    #* User checks all params in response "responseAfterCreating"
    #  | name      | EV1333                                                     |
    #  | full_name | EVZaykov/EV1333                                            |
    #  | url       | https://api.github.com/repos/EVZaykov/EV1333               |

