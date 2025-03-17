import { locators } from '../../utils/constants';
import { BaseDependencies,BaseEyes } from '../BaseRobot';

export class HomePageDependencies extends BaseDependencies {
    visitAmazonPage() {
        this.accessUrl(locators.amazonUrl);
    }
}
export class HomePageEyes extends BaseEyes {
    seesMainPage() {
        this.seesDomVisible(locators.mainPageBody);
    }
}
