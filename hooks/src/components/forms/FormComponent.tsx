import React from 'react';
import { useForm } from "react-hook-form";
import { TextField, Button, Box, Typography } from '@mui/material';

// Define the types for the form data
interface FormData {
  firstName: string;
  middleName?: string;
  lastName: string;
}

const FormComponent: React.FC = () => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<FormData>();

  const onSubmit = async (data: FormData) => {
    
    await new Promise((resolve) => setTimeout(resolve, 5000));
    alert("submitting your form please wait");
    console.log("submitting the form", data);
  };

  return (
    <Box
      component="form"
      onSubmit={handleSubmit(onSubmit)}
      sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 2, mt: 5 }}
    >
      <Typography variant="h4" component="h1">Form Example</Typography>

      <TextField
        label="First Name"
        variant="outlined"
        error={!!errors.firstName}
        helperText={errors.firstName ? errors.firstName.message : ''}
        {...register('firstName', {
          required: "First Name is required",
          minLength: { value: 3, message: 'Min length is 3 characters' },
          maxLength: { value: 10, message: 'Max length is 6 characters' }
        })}
        fullWidth
      />

      <TextField
        label="Middle Name"
        variant="outlined"
        {...register('middleName')}
        fullWidth
      />

      <TextField
        label="Last Name"
        variant="outlined"
        error={!!errors.lastName}
        helperText={errors.lastName ? errors.lastName.message : ''}
        {...register('lastName', {
          pattern: {
            value: /^[A-Za-z]+$/i,
            message: "Last Name must contain only letters"
          }
        })}
        fullWidth
      />

      <Button
        type="submit"
        variant="contained"
        color="primary"
        disabled={isSubmitting}
        fullWidth
      >
        {isSubmitting ? "Submitting..." : "Submit"}
      </Button>
    </Box>
  );
};

export default FormComponent;
