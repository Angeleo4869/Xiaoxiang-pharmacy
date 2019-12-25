import React from 'react';
import { Checkbox } from '@material-ui/core';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import TableCell from '@material-ui/core/TableCell';
import TableRow from '@material-ui/core/TableRow';
import { useEffect } from 'react';
import Typography from '@material-ui/core/Typography';
import Hidden from '@material-ui/core/Hidden';
import Button from '@material-ui/core/Button';
import AddIcon from '@material-ui/icons/Add';
import Box from '@material-ui/core/Box';
import RemoveIcon from '@material-ui/icons/Remove';

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

export default function GoodsCard(props) {
        const row = props.row;
        const [check,setcheck] = React.useState(false)
        const [Gnum,setGnum] = React.useState(1)
        
        useEffect(
            ()=>{
                setcheck(props.check)
            },[props]
        )
        //高阶组件 事件得到源 
        const checklist = (event)=>{
            var check = event.target.checked
            //   console.log(event.target.checked)
            setcheck(check)
            if(sessionStorage.getItem("shopPirce")!=null){
              sessionStorage.getItem("shopPirce")
            }else{
              sessionStorage.setItem("shopPirce","")
            }
            
          }

        const addGunm=()=>{
          setGnum( Gnum+1)
        }
        const subGnum=()=>{
            if(Gnum>0){
              setGnum(Gnum-1)
            }
        }
        return(
            <StyledTableRow >
                <StyledTableCell ><Checkbox checked={check} onClick={(e)=>checklist(e)} /></StyledTableCell>
                <StyledTableCell component="th" scope="row">
                  {/* 商品图片以及商品名称 */}
                <div style={{display:'flex'}}>
                    <span>
                    <img style={{width:'70px', height:'50px',float:'left', marginRight:'10px'}} alt="images" src='/Pic/D1.jpg'/>
                    </span>
                    <div style={{width:'70px', height:'auto', lineHeight:'15px',overflow:'hidden', fontSize:'14px',wordWrap:'break-word',
                wordBreak:'break-all'}}>你好你好你好你好</div>
                </div>
                </StyledTableCell>
                
                <Hidden xsDown>
                  <StyledTableCell align="right">￥{row.price}元</StyledTableCell>
                  <StyledTableCell align="right">
                  <div style={{display:'flex',marginTop:10}}>
                        <Box style={{border:'1px solid #f0f0f0',height:25}} >
                            <AddIcon onClick={addGunm}/>
                        </Box>
                        <Box style={{height:25,width:40,border:'1px solid #f0f0f0'}}>
                            <center>
                            <h3 style={{marginTop:2,}}>{Gnum}</h3>
                            </center>
                        </Box>
                        <Box style={{border:'1px solid #f0f0f0',height:25}} >
                            <RemoveIcon onClick={subGnum}/>
                        </Box>
                    </div>
                  </StyledTableCell>
                  <StyledTableCell align="right">￥{row.tol}元</StyledTableCell>
                  <StyledTableCell align="right"><button>删除</button> </StyledTableCell> 
                </Hidden>
                <Hidden smUp>
                  <StyledTableCell align="right">
                    <div style={{width:`calc(40vw)`,marginLeft:-60}}>
                      <Typography color="primary">
                        ￥{row.price}元
                      </Typography>
                      <div style={{display:'flex',marginTop:5,marginLeft:80,marginBottom:5}}>
                        <Box style={{border:'1px solid #f0f0f0',height:25}} >
                            <AddIcon onClick={addGunm}/>
                        </Box>
                        <Box style={{height:25,width:40,border:'1px solid #f0f0f0'}}>
                            <center>
                            <h3 style={{marginTop:2,}}>{Gnum}</h3>
                            </center>
                        </Box>
                        <Box style={{border:'1px solid #f0f0f0',height:25}} >
                            <RemoveIcon onClick={subGnum}/>
                        </Box>
                    </div>
                      <Typography>
                      ￥{row.tol}元
                      </Typography>
                      <Button variant="outlined">
                        删除
                      </Button>
                    </div>
                  </StyledTableCell>
                </Hidden>
            </StyledTableRow>
        );
}

