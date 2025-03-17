import { locators } from "../../utils/constants";
import { BaseEyes, BaseHands } from "../BaseRobot";

export class OrderBaseHands extends BaseHands {
  clickOrders() {
    this.clickOnId(locators.ordersButton);
  }

  pastOrder() {
    this.clickOnId(locators.pastOrderButton);
    this.clickOnId(locators.timeFilter);
  }
}

export class OrderBaseEyes extends BaseEyes {
  verifyPastOrder() {
    this.seesDomVisible(locators.verifyPastOrder);
  }
}
