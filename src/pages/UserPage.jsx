import * as React from "react";
import OutlinedInput from "@mui/material/OutlinedInput";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import ListItemText from "@mui/material/ListItemText";
import Select from "@mui/material/Select";
import Checkbox from "@mui/material/Checkbox";
import { UserCourseTable } from "../components/UserCourseTable";
import { useState } from "react";
import Box from "@mui/material/Box";
import LoadingButton from "@mui/lab/LoadingButton";
import Slider from "@mui/material/Slider";

const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};

const names = [
  "Oliver Hansen",
  "Van Henry",
  "April Tucker",
  "Ralph Hubbard",
  "Omar Alexander",
  "Carlos Abbott",
  "Miriam Wagner",
  "Bradley Wilkerson",
  "Virginia Andrews",
  "Kelly Snyder",
];

export function UserPage() {
  const [personName, setPersonName] = useState([]);
  const [selectedCourses, setSelectedCourses] = useState([])

  const handleChange = (event) => {
    const {
      target: { value },
    } = event;
    setPersonName(
      // On autofill we get a stringified value.
      typeof value === "string" ? value.split(",") : value
    );
  };

  return (
    <div>
      <FormControl sx={{ m: 1, width: 300 }}>
        <InputLabel id="demo-multiple-checkbox-label">Tag</InputLabel>
        <Select
          labelId="demo-multiple-checkbox-label"
          id="demo-multiple-checkbox"
          multiple
          value={personName}
          onChange={handleChange}
          input={<OutlinedInput label="Tag" />}
          renderValue={(selected) => selected.join(", ")}
          MenuProps={MenuProps}
        >
          {names.map((name) => (
            <MenuItem key={name} value={name}>
              <Checkbox checked={personName.indexOf(name) > -1} />
              <ListItemText primary={name} />
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      {/* <UserCourseTable courses={personName} /> */}
      <Box width={300}>
        <h1>Schedule intensity</h1>
        <Slider
          defaultValue={50}
          min={1}
          max={50}
          aria-label="Default"
          valueLabelDisplay="auto"
        />
      </Box>
      <Box width={300}>
        <h1>intensity percentage</h1>
        <Slider
          defaultValue={50}
          min={0}
          max={100}
          aria-label="Default"
          valueLabelDisplay="auto"
        />
      </Box>
      <Box width={300}>
        <h1>Availability</h1>
        <Slider
          defaultValue={50}
          min={1}
          max={50}
          aria-label="Default"
          valueLabelDisplay="auto"
        />
      </Box>
      <Box width={300}>
        <h1>Availability Percentage</h1>
        <Slider
          defaultValue={0}
          min={0}
          max={100}
          aria-label="Default"
          valueLabelDisplay="auto"
        />
      </Box>
      <Box width={300}>
        <h1>Minimum Credits</h1>
        <Slider
          defaultValue={1}
          min={1}
          max={40}
          aria-label="Default"
          valueLabelDisplay="auto"
        />
      </Box>
      <div style={{display: "flex", justifyContent: "center"}}>
      <LoadingButton
        onClick={()=> console.log('')}
        loading={false}
        loadingIndicator="Loading…"
        variant="outlined"
        >
        Fetch data
      </LoadingButton>
          </div>
    </div>
  );
}
