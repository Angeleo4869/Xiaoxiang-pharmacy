import React, { useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import { Card } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import Divider from '@material-ui/core/Divider';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import Button from '@material-ui/core/Button';
import axios from 'axios';
import cookie from 'react-cookies';
import {Link} from 'react-router-dom';
const useStyles = makeStyles(theme => ({
    root: {
      padding: theme.spacing(1, 3),
      marginLeft:10,
    },
    cardstyle: {
      position:'relative',
      left:10,
      width:`calc(100vw - 230px)`,
      minWidth:200,
      [theme.breakpoints.down('xs')]: {
          width: '96vw',
      },
    },
    address: {
      width:`calc(100vw - 230px)`,
      [theme.breakpoints.down('sm')]: {
        width:470,
      },
    },
    formControl: {
        margin: theme.spacing(1),
        minWidth: 120,
      },
}));

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

const arealist=['北京市','上海市','天津市','重庆市','河北省','山西省','辽宁省','吉林省','河南省','江苏省','浙江省','安徽省','福建省','江西省','山东省','湖北省','湖南省','广东省','海南省','四川省','贵州省','云南省','陕西省','甘肃省','青海省','黑龙江省','内蒙古自治区','广西壮族自治区','西藏自治区','宁夏回族自治区','新疆维吾尔自治区','台湾省','香港特别行政区','澳门特别行政区'];
const citylist=['东城区','西城区','崇文区','宣武区','朝阳区','海淀区','丰台区','石景山区','房山区','通州区','顺义区','门头沟区','昌平区','大兴区','怀柔区','平谷区','密云县','延庆县'];
const countrysidelist=['xx县','yy县','zz县','qq县']

export default function PaperSheet() {
    const classes = useStyles();
    const [age, setAge] = React.useState('');
    const [open, setOpen] = React.useState(false);

    const handleChange = event => {
        // alert(event.target.value);
        setAge(event.target.value);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleOpen = () => {
        setOpen(true);
    };

    const [age1, setAge1] = React.useState('');
    const [open1, setOpen1] = React.useState(false);

    const handleChange1 = event => {
        // alert(event.target.value);
        setAge1(event.target.value);
    };

    const handleClose1 = () => {
        setOpen1(false);
    };

    const handleOpen1 = () => {
        setOpen1(true);
    };

    const [age2, setAge2] = React.useState('');
    const [open2, setOpen2] = React.useState(false);

    const handleChange2 = event => {
        // alert(event.target.value);
        setAge2(event.target.value);
    };

    const handleClose2 = () => {
        setOpen2(false);
    };

    const handleOpen2 = () => {
        setOpen2(true);
    };

    const [state, setState] = React.useState({
        checkedA: true,
        checkedB: true,
      });
    var idaddress = '';
      const handleChange3= name => event => {
        setState({ ...state, [name]: event.target.checked });
      };
      useEffect(
        ()=>{
          if(sessionStorage.getItem("Defaultmessage")!=null){
            var DAM = JSON.parse(sessionStorage.getItem("Defaultmessage"))
            setAge(DAM.province)
            setAge1(DAM.city)
            setAge2(DAM.detail)
            document.getElementById("Gpeople").value = DAM.name;
            document.getElementById("Gphone").value = DAM.phone;
            idaddress = DAM.id;
          }else{
            alert("请不要直接访问该页面")
              window.location.href = global.data.localadd +'PersonCenter/show/address'
          }
        }
      )

      const Bclick = () =>{
        var name = document.getElementById("Gpeople").value;
        var phone = document.getElementById("Gphone").value;
        var Adetail = age2 +  document.getElementById("indetail").value;
        
            if(cookie.load('userdId')==null){
              if(idaddress!==''&&name!==''&&phone!==''&&age!==''&&age1!==''&&Adetail!==''&&document.getElementById("indetail").value!==''){
                axios.get(global.data.request+'addOrChangeAddress.action',
                {
                  params: {
                    RecipientName: name,
                    RecipientTel: phone,
                    Provinces: age,
                    City: age1,
                    AddressDetail: Adetail,
                    idBuyer: cookie.load('userId'),
                    idaddress : idaddress
                  }
                }).then(
                  (response)=>{
                    alert(response.data.success)
                    sessionStorage.removeItem("Defaultmessage");
                    window.location.href = global.data.localadd +'PersonCenter'
                    // console.log(response.data)
                  }
                )
              }else{
                alert("input message")
              }
            }else{
              alert("请登录")
              window.location.href = global.data.localadd +'Login'
            }
          
        }
        
  return (
    <div style={{width:'100%'}}>
        <div style={{display:'flex',width:'100%'}}>
          <Typography variant="h6" style={{margin:5,marginLeft:15}} >
              修改收货地址
          </Typography>
        </div>
        <Divider style={{position:'relative',top:10,left:10}}/>
            <div style={{display:'inline',position:'relative',left:10}} >
                <TextField
                id="Gpeople"
                label="收 货 人"
                type="search"
                className={classes.address}
                margin="normal"
                variant="filled"
                />
                <TextField
                id="Gphone"
                label="手机号码"
                type="search"
                className={classes.address}
                margin="normal"
                variant="filled"
                style={{marginTop:-5}}
                />

                <FormControl className={classes.formControl}>
                  <InputLabel id="demo-controlled-open-select-label">所在省</InputLabel>
                    <Select
                    labelId="demo-controlled-open-select-label"
                    id="demo-controlled-open-select"
                    open={open}
                    onClose={handleClose}
                    onOpen={handleOpen}
                    value={age}
                    onChange={handleChange}
                    MenuProps={MenuProps}
                    >
                    
                    {arealist.map((test)=>(
                        <MenuItem key={test} value={test}>
                            {test}
                        </MenuItem>
                    ))}
                    </Select>
                </FormControl>

                <FormControl className={classes.formControl}>
                  <InputLabel id="demo-controlled-open-select-label">所在市</InputLabel>
                    <Select
                    labelId="demo-controlled-open-select-label"
                    id="demo-controlled-open-select"
                    open={open1}
                    onClose={handleClose1}
                    onOpen={handleOpen1}
                    value={age1}
                    onChange={handleChange1}
                    MenuProps={MenuProps}
                    >
                    {citylist.map((test)=>(
                        <MenuItem key={test} value={test}>
                            {test}
                        </MenuItem>
                    ))}
                    </Select>
                </FormControl>

                <FormControl className={classes.formControl}>
                  <InputLabel id="demo-controlled-open-select-label">所在区/县</InputLabel>
                    <Select
                    labelId="demo-controlled-open-select-label"
                    id="demo-controlled-open-select"
                    open={open2}
                    onClose={handleClose2}
                    onOpen={handleOpen2}
                    value={age2}
                    onChange={handleChange2}
                    MenuProps={MenuProps}
                    >
                    {countrysidelist.map((test)=>(
                        <MenuItem key={test} value={test}>
                            {test}
                        </MenuItem>
                    ))}
                    </Select>
                </FormControl>

                <TextField
                id="indetail"
                label="详细地址：如道路、门牌号、小区、楼栋号、单元室等"
                type="search"
                className={classes.address}
                margin="normal"
                variant="filled"
                style={{marginTop:-5}}
                />
                <div style={{display:'flex',width:'100%'}}>
                    <Typography variant="h6" style={{margin:5,marginLeft:15}} >
                        设置默认地址
                    </Typography>
                    <FormControlLabel
                        control={
                        <Switch checked={state.checkedA} onChange={handleChange3('checkedA')} value="checkedA" />
                        }
                    />
                </div>
                <Link to="/PersonCenter/show/address" onClick={Bclick}>
                  <Button >确认</Button>
                </Link>
                
                <Divider style={{position:'relative',top:10,left:0}}/>
            </div>
            <div style={{height:95}}>s</div>{/* 注意一定要加，不然显示不全 */}
    </div>
  );
}