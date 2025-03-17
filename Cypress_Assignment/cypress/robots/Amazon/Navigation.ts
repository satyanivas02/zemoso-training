import { locators } from "../../utils/constants";
import { BaseEyes, BaseHands } from "../BaseRobot";

export class NavigationHands extends BaseHands {
  navigateToMobilesAndBack() {
    this.clickOnId(locators.hamburgerMenuButton);
    this.clickOnDomElement(locators.mobilesCategory);
  }

  backtoMainMenu() {
    this.clickOnId(locators.closeMenuButton);
  }
}

export class NavigationEyes extends BaseEyes {
  verifyMobilesSelection() {
    this.seesIdVisible(locators.verifyMobilesClick);
  }
}
