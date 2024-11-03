import React from 'react';
import { Tabs as MUITabs, Tab } from '@mui/material';

interface TabsProps {
  currentTab: number;
  handleTabChange: (event: React.SyntheticEvent, newValue: number) => void;
}

const Tabs: React.FC<TabsProps> = ({ currentTab, handleTabChange }) => {
  return (
    <MUITabs value={currentTab} onChange={handleTabChange}>
      <Tab label="Currently reading" />
      <Tab label="Finished" />
    </MUITabs>
  );
};

export default Tabs;

