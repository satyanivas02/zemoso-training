import { useAuth0 } from "@auth0/auth0-react";
import React from "react";
import { CircularProgress, Avatar, Typography, Box } from "@mui/material";

const Profile: React.FC = () => {
  const { user, isAuthenticated, isLoading } = useAuth0();

  if (isLoading) {
    return <CircularProgress />;
  }

  return (
    isAuthenticated && user ? (
      <Box display="flex" flexDirection="column" alignItems="center" gap={2}>
        <Avatar src={user.picture} alt={user.name} sx={{ width: 100, height: 100 }} />
        <Typography variant="h5">{user.name}</Typography>
        <Typography variant="body1">{user.email}</Typography>
      </Box>
    ) : null
  );
};

export default Profile;
