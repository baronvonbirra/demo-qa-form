const fullUserList = ["Jan van Dam", "Chack Norris", "Klark n Kent", "John Daw", "Bat Man", "Tim Los", "Dave o Core", "Pay Pal", "Lazy Cat", "Jack & Johnes"];

export let updatedUserList = fullUserList;

function getRandomUser() {
  const userPos = Math.floor(Math.random() * ((updatedUserList.length) - 0));
  console.log(updatedUserList[userPos]);
  const selectedUser = updatedUserList[userPos];
  const remove = updatedUserList.splice(userPos, 1);
  return selectedUser;
}

function randomSelector(options) {
  return (Math.floor(Math.random() * options) + 1);
}

function phoneGenerator() {
  const length = 10;
  let mask = '0123456789';
  let result = '';
  for (var i = length; i > 0; --i) result += mask[Math.floor(Math.random() * mask.length)];
  return result;
}

function randomDate() {
  const date = new Date(+(new Date()) - Math.floor(Math.random() * 10000000000));
  return date.getDate() + " Nov " + date.getFullYear();
}

function randomSubjectSelector() {
  const length = 1;
  let mask = 'abcdeghilmnoprstuvy';
  let result = '';
  for (var i = length; i > 0; --i) result += mask[Math.floor(Math.random() * mask.length)];
  return result;
}

function randomAddress() {
  const length = 20;
  const chars = '#aA!';
  let mask = '';

  if (chars.indexOf('a') > -1) mask += 'abcdefghijklmnopqrstuvwxyz';
  if (chars.indexOf('A') > -1) mask += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  if (chars.indexOf('#') > -1) mask += '0123456789';
  if (chars.indexOf('!') > -1) mask += ' ~`!@#$%^&*()_+-={}[]:";\'<>?,./|\\';
  let result = '';
  for (var i = length; i > 0; --i) result += mask[Math.floor(Math.random() * mask.length)];
  return result;
}

export function registerUser() {
  const user = getRandomUser();
  const userName = user.split(' ')[0];
  let userSurname = user.split(' ');
  userSurname = userSurname[userSurname.length - 1]

  cy.get('#firstName')
    .click()
    .type(userName);
  cy.get('#lastName')
    .click()
    .type(userSurname);
  cy.get('#userEmail')
    .click()
    .type(`${userName}${userSurname}@demoqa.com`);
  cy.get(`#gender-radio-${randomSelector(3)}`)
    .click({ force: true });
  cy.get('#userNumber')
    .click()
    .type(phoneGenerator());
  cy.get('#dateOfBirthInput')
    .click()
    .type('{selectall}')
    .type(randomDate())
    .type('{enter}');
  cy.get(`#hobbies-checkbox-${randomSelector(3)}`)
    .click({ force: true });
  cy.get('#subjectsContainer')
    .click()
    .type(randomSubjectSelector())
    .find('.subjects-auto-complete__menu')
    .children()
    .first()
    .click();
  cy.get('#currentAddress')
    .click()
    .type(randomAddress());
  cy.get('#state')
    .click()
    .find(`#react-select-3-option-${randomSelector(3)}`)
    .click();
  cy.get('#city')
    .click()
    .find('#react-select-4-option-0')
    .click();
  cy.get('#submit')
    .click();
  cy.get('.modal-content')
    .should('contain', 'Thanks for submitting the form');
  cy.get('#closeLargeModal')
    .click();
}
