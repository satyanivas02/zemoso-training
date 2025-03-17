import { locators } from "../../utils/constants";
import { BaseEyes, BaseHands } from "../BaseRobot";

export class AddressHands extends BaseHands {
  addNewAddress() {
    this.clickOnDomElement(locators.breadcrumbsCrumb);
    this.clickDomElementwithXpath(locators.yourAddresses);
    this.clickOnId(locators.addAddressLink);
    this.typeTextonId(locators.fullNameField, Cypress.env("FULL_NAME"));
    this.typeTextonId(locators.phoneNumberField, Cypress.env("PHONE_FIELD"));
    this.typeTextonId(
      locators.postalCodeField,
      Cypress.env("POSTAL_CODE_FIELD")
    );
    this.typeTextonId(
      locators.addressLine1Field,
      Cypress.env("ADDRESS_LINE1_FIELD")
    );
    this.typeTextonId(
      locators.addressLine2Field,
      Cypress.env("ADDRESS_LINE2_FIELD")
    );
    this.typeTextonId(locators.landmarkField, Cypress.env("LANDMARK_FIELD"));
    this.clickOnId(locators.defaultAddressCheckbox);
    this.clickDomElementwithXpath(locators.submitButton);
  }
}
export class AddressEyes extends BaseEyes {
  verifyAddress() {
    this.seesTextWithxpath(locators.addressSavedText, locators.addressText);
  }
}
