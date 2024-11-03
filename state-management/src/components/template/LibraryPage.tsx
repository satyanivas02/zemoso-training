// import React, { useState } from 'react';
// import Tabs from '../molecules/Tabs';
// import LibraryGrid from '../organisms/LibraryGrid';
// import Text from '../atoms/Text';
// import Icon from '../atoms/Icon';
// import { ICONS } from '../../constants/icons';

// const LibraryPage: React.FC = () => {
//   const [currentTab, setCurrentTab] = useState(0);

//   const handleTabChange = (event: React.SyntheticEvent, newValue: number) => {
//     setCurrentTab(newValue);
//   };

//   return (
//     <div>
//       <header style={{ display: 'flex', justifyContent: 'space-between', padding: '16px 32px' }}>
//         <Icon src={ICONS.blinkistLogo} alt="Blinkist Logo" />
//         <Icon src={ICONS.profileIcon} alt="Profile Icon" />
//       </header>
//       <Text variant="h1">My Library</Text>
//       <Tabs currentTab={currentTab} handleTabChange={handleTabChange} />
//       <LibraryGrid currentTab={currentTab} />
//     </div>
//   );
// };

// export default LibraryPage;

// import React, { useState } from 'react';
// import { Box } from '@mui/material';
// import Tabs from '../molecules/Tabs';
// import LibraryGrid from '../organisms/LibraryGrid';
// import Text from '../atoms/Text';
// import Icon from '../atoms/Icon';
// import { ICONS } from '../../constants/icons';

// const LibraryPage: React.FC = () => {
//   const [currentTab, setCurrentTab] = useState(0);

//   const handleTabChange = (event: React.SyntheticEvent, newValue: number) => {
//     setCurrentTab(newValue);
//   };

//   return (
//     <Box>
//       <Box component="header" sx={{ display: 'flex', justifyContent: 'space-between', px: 4, py: 2 }}>
//         <Icon src={ICONS.blinkistLogo} alt="Blinkist Logo" />
//         <Icon src={ICONS.profileIcon} alt="Profile Icon" />
//       </Box>
//       <Text variant="h1">My Library</Text>
//       <Tabs currentTab={currentTab} handleTabChange={handleTabChange} />
//       <LibraryGrid currentTab={currentTab}/>
//     </Box>
//   );
// };

// export default LibraryPage;

import React, { useState } from 'react';
import { Box } from '@mui/material';
import Tabs from '../molecules/Tabs';
import LibraryGrid from '../organisms/LibraryGrid';
import Text from '../atoms/Text';
import Icon from '../atoms/Icon';
import { ICONS } from '../../constants/icons';
import { cardData as initialCardData } from '../../constants/cardData';

const LibraryPage: React.FC = () => {
  const [currentTab, setCurrentTab] = useState(0);
  const [currentlyReading, setCurrentlyReading] = useState(initialCardData.currentlyReading);
  const [finished, setFinished] = useState(initialCardData.finished);

  const handleTabChange = (event: React.SyntheticEvent, newValue: number) => {
    setCurrentTab(newValue);
  };

  const handleFinishBook = (book: any) => {
    setCurrentlyReading(currentlyReading.filter((item) => item.title !== book.title));
    setFinished([...finished, book]);
  };

  const handleReadAgain = (book: any) => {
    setFinished(finished.filter((item) => item.title !== book.title));
    setCurrentlyReading([...currentlyReading, book]);
  };

  return (
    <Box>
      <Box component="header" sx={{ display: 'flex', justifyContent: 'space-between', px: 4, py: 2 }}>
        <Icon src={ICONS.blinkistLogo} alt="Blinkist Logo" width="124.09px" height="26px" />  
        <Icon src={ICONS.profileIcon} alt="Profile Icon" width="60px" height="40px" />  
      </Box>

      <Text variant="h1">My Library</Text>
      <Tabs currentTab={currentTab} handleTabChange={handleTabChange} />
      <LibraryGrid 
        currentTab={currentTab} 
        currentlyReading={currentlyReading} 
        finished={finished} 
        onFinishBook={handleFinishBook} 
        onReadAgain={handleReadAgain} 
      />
    </Box>
  );
};

export default LibraryPage;
