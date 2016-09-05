Feature: Login usuario

  Scenario: login com sucesso
    Given Que acesso a pagina de login
    And Digito usuario "usuario"
    And Digito senha "usuario"
    And Clico no login
    Then Usuario logado "usuario"
 