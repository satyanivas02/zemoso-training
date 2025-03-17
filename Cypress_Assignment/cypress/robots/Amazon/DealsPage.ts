import { locators } from '../../utils/constants';
import { BaseHands ,BaseEyes } from '../BaseRobot';

export class TodaysDealsHands extends BaseHands {
    clickOnTodaysDeals() {
        this.clickOnDomElement(locators.todaysDealsLink);
        
    }

    selectThirdDeal() {
        this.clickDomElementwithXpath(locators.thirdDeal);
    }
}
export class TodaysDealsEyes extends BaseEyes {
    seesTodaysDeals() {
        this.seesDomVisible(locators.todaysDealsLink);
    }
}
