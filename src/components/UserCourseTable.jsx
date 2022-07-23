import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useState,useEffect } from "react";

function createData(name, calories, fat, carbs, protein) {
  return { name, calories, fat, carbs, protein };
}

const rows = [
  createData("Frozen yoghurt", 159, 6.0, 24, 4.0),
  createData("Ice cream sandwich", 237, 9.0, 37, 4.3),
  createData("Eclair", 262, 16.0, 24, 6.0),
  createData("Cupcake", 305, 3.7, 67, 4.3),
  createData("Gingerbread", 356, 16.0, 49, 3.9),
];



export function UserCourseTable(courses) {
    const [selectedCourses, setSelectedCourses] = useState([])
    const [tableCourses, setTableCourses] = useState([])

    useEffect(() => {
      setSelectedCourses(() => courses);
      createRows(selectedCourses);
      console.log(selectedCourses);
    }, [courses]);
    

    const createRows = (coursesToShow, a =1 ,b =2 , c=3, d=4) => {
    
    }
    if (!selectedCourses.length) return
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Courses</TableCell>
            <TableCell align="right">Difficulty</TableCell>
            <TableCell align="right">Credit Points</TableCell>
            <TableCell align="right">Mandatory</TableCell>
            <TableCell align="right">Protein&nbsp;(g)</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {selectedCourses.map((row) => (
            <TableRow
              key={row}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row}
              </TableCell>
              <TableCell align="right">{row}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
