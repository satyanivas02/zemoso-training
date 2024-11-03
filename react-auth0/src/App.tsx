// src/App.tsx
import React from "react";
import { Auth0Provider } from "@auth0/auth0-react";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";
import Profile from "./components/Profile";
import { Container, Box } from "@mui/material";

const App: React.FC = () => {
  return (
    <Auth0Provider
      domain="dev-8ocyekmzn78q75b0.us.auth0.com"
      clientId="IRcVdfBnoqlQPE1Wswh2Tj8ye7avadSB"
      authorizationParams={{
        redirect_uri: window.location.origin
      }}
    >
      <Container>
        <Box display="flex" flexDirection="column" alignItems="center" gap={2} mt={5}>
          <LoginButton />
          <LogoutButton />
          <Profile />
        </Box>
      </Container>
    </Auth0Provider>
  );
};

export default App;
