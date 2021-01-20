import { Given, Then } from "cypress-cucumber-preprocessor/steps";
import { updatedUserList, registerUser } from "../helper/helper";

Given(`I open {string} page`, (page) => {
  cy.visit(page);
})

Given(`I see the URL is {string}`, (url) => {
  cy.url().should('eq', url)
})

Given(`I register {string} random user`, (pos) => {
  registerUser();
})

Then(`I output the non-registered users`, () => {
  cy.log(`Non-registered users are: ${updatedUserList}`);
})
