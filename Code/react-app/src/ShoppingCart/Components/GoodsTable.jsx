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

const StyledTableRow = withStyles(theme => ({
  root: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.background.default,
    },
  },
}))(TableRow);

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
    overflowX: 'auto',
  },
  table: {
    minWidth: 700,
  },
}));

export default function CustomizedTables() {
  const classes = useStyles();

  return (
    <Paper className={classes.root}>
      <Table className={classes.table} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell><Checkbox/>全选</StyledTableCell>
            <StyledTableCell align="left">商品信息</StyledTableCell>
            <StyledTableCell align="right">单价</StyledTableCell>
            <StyledTableCell align="right">数量</StyledTableCell>
            <StyledTableCell align="right">小计</StyledTableCell>
            <StyledTableCell align="right">操作</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => (
            <StyledTableRow key={row.name}>
                <StyledTableCell ><Checkbox/></StyledTableCell>
                <StyledTableCell component="th" scope="row">
                  {/* 商品图片以及商品名称 */}
                  <GoodsCard></GoodsCard>
                </StyledTableCell>
                <StyledTableCell align="right">￥{row.price}元</StyledTableCell>
                <StyledTableCell align="right">{row.count}(个/盒)</StyledTableCell>
                <StyledTableCell align="right">￥{row.tol}元</StyledTableCell>
                <StyledTableCell align="right"><button>删除</button> </StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </Paper>
  );
}

