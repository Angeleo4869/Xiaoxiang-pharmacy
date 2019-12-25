import React from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { Checkbox } from '@material-ui/core';
import GoodsCard from '../Components/GoodsCard';
import Hidden from '@material-ui/core/Hidden';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
const StyledTableCell = withStyles(theme => ({
  head: {
    backgroundColor: theme.palette.common.white,
    color: theme.palette.common.black,
    fontSize:18
  },
  body: {
    fontSize: 13,
  },
  
}))(TableCell);


function createData( price, count) {
  var tol = count * price;
  return {price, count, tol};
}

const rows = [
  createData(10,20),
  createData(5,30),
  createData(30,2),
  createData(15.5,4),
  createData(21.6,5),
];

const useStyles = makeStyles(theme => ({
  root: {
    width: '100%',
    marginTop: theme.spacing(3),
    overflowX: 'visible',
  },
  table: {
    width: `calc(100vw - 250px)`
  },
  bottom: {
    position:'fixed',
    bottom:0,
    paddingTop:10,
    width: `calc(100vw - 250px)`,
    height:60,
    [theme.breakpoints.down('xs')]: {
      width: `100vw`,
      paddingRight:300
    },
  }
  
}));



export default function CustomizedTables() {
  const classes = useStyles();
  const [check,setcheck] = React.useState(false);
  const ccheck = ()=>{
    setcheck(!check)
  }
  
  return (
    <Paper className={classes.root}>
      <Table className={classes.table} aria-label="customized table">
        <Hidden xsDown>
        <TableHead>
          <TableRow>
            <StyledTableCell><Checkbox checked={check} onClick={ccheck} />全选</StyledTableCell>
            <StyledTableCell align="left">商品信息</StyledTableCell>
            <StyledTableCell align="right">单价</StyledTableCell>
            <StyledTableCell align="right">数量</StyledTableCell>
            <StyledTableCell align="right">小计</StyledTableCell>
            <StyledTableCell align="right">操作</StyledTableCell>
          </TableRow>
        </TableHead>
        </Hidden>
        <TableBody >
          {rows.map((row,index) => (
              <GoodsCard key={index} row={row} check={check} />
          ))}
        </TableBody>
      </Table>
      <Box bgcolor="#0000FF"  p={2} className={classes.bottom} >
        <div>
        <Checkbox checked={check} onClick={ccheck} />全选
        <span style={{position:'absolute',right:0}}>
          合计:￥99&nbsp;&nbsp;<Button variant="contained" color="secondary">结算</Button>&nbsp;
        </span>
        </div>
        
      </Box>
    </Paper>
  );
}

