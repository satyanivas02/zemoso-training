import { locators } from "../../utils/constants";
import { BaseHands, BaseEyes } from "../BaseRobot";

export class SearchHands extends BaseHands {
  searchMobiles() {
    this.typeTextonId(locators.searchBox, locators.mobilesText);
    this.clickOnId(locators.searchButton);
  }

  getLastDisplayedItems() {
    this.getLastDisplayedItemDetails(
      locators.lastDisplayedItemContainer,
      locators.lastDisplayedItemTitle,
      locators.lastDisplayedItemPrice
    ).then((details) => {
      this.logItemDetails(details);
    });
  }
}
export class SearchEyes extends BaseEyes {
  verifycategory() {
    this.seesDomVisible(locators.verifysearch);
  }
}
