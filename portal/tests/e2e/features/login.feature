Feature: Use the shopping cart

  Scenario: Seeing empty cart
    Given Que acesso a pagina de login
    And Digito usuario "usuario"
    And Digito senha "usuario"
    And Clico no login
    Then Usuario logado "usuario"
 