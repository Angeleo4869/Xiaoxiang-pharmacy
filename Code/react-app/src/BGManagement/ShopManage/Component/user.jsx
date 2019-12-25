import React,{useEffect} from 'react';
import MaterialTable from 'material-table';
import { makeStyles } from '@material-ui/core/styles';
import axios from 'axios';

const useStyles = makeStyles(theme => ({
    root: {
      width:"100vw "
    }
  }));

export default function MaterialTableDemo() {
    const classes = useStyles();
    const [state, setState] = React.useState({
    columns: [
      { title: 'ID', field: 'id' },
      { title: '邮箱', field: 'email' },
      { title: '头像', field: 'headpor' },
      { title: '真实姓名', field: 'rname'},
      { title: '账号', field: 'anumber' },
      { title: '密码', field: 'pwd'},
      { title: '手机号', field: 'pnumber' },
      
      // { title: '地址ID', field: 'aid' },
      // { title: '收货人', field: 'gpeople' },
      // { title: '收货号码', field: 'gphone'},
      // { title: '省', field: 'province' },
      // { title: '市', field: 'city'},
      // { title: '区', field: 'detail' },
      

      // { title: 'Birth Year', field: 'birthYear', type: 'numeric' },
      // {
      //   title: 'Birth Place',
      //   field: 'birthCity',
      //   lookup: { 34: 'İstanbul', 63: 'Şanlıurfa' },
      // },
    ],
    data: [
      { email: '26566666@qq.com',
        headpor: 'Baran',
        rname: 'xiaofeng',
        anumber: '12345678909',
        pwd: 'qweqweqweqeqw',
        pnumber: '12343211234',
        id: '12',

        // aid: '2',
        // gpeople: 'xiaofeng',
        // gphone: '12332123456',
        // province: '湖南省',
        // city: '长沙市',
        // detail: '岳麓区',

        // birthYear: 1987, 
        // birthCity: 63 
      },
      {
        email: '26566666@qq.com',
        headpor: 'Baran',
        rname: 'xiaofeng',
        anumber: '12345678909',
        pwd: 'qweqweqweqeqw',
        pnumber: '12343211234',
        id: '13',

        // aid: '2',
        // gpeople: 'xiaofeng',
        // gphone: '12332123456',
        // province: '湖南省',
        // city: '长沙市',
        // detail: '岳麓区',

        // birthYear: 2017,
        // birthCity: 34,
      },
    ],
  });

  useEffect(
    ()=>{
      axios.get("http://118.25.67.96:8080/XiaoXiangPharmacy/AllBuyer.action").then(
        (response)=>{
          var column = [
            { title: 'ID', field: 'idBuyer' },
            { title: '邮箱', field: 'buyerEmail' },
            { title: '头像', field: 'buyerHeadpor' },
            { title: '真实姓名', field: 'buyerName'},
            { title: '账号', field: 'buyerNumber' },
            { title: '密码', field: 'buyerPassword'},
            { title: '手机号', field: 'buyerTel' },]
            var data = response.data.Buyer.filter(item => delete item.shippingaddress)
            var len;
            for(var j = 0,len=data.length; j < len; j++) {
              if(data[j].idBuyer==null)
                data[j].idBuyer="未设置"
              if(data[j].buyerEmail==null)
                data[j].buyerEmail="未设置"
              if(data[j].buyerHeadpor==null)
                data[j].buyerHeadpor="未设置"
              if(data[j].buyerName==null)
                data[j].buyerName="未设置"
              if(data[j].buyerNumber==null)
                data[j].buyerNumber="未设置"
              if(data[j].buyerPassword==null)
                data[j].buyerPassword="未设置"
              if(data[j].buyerTel==null)
                data[j].buyerTel="未设置"
            }
            var Adata = {'columns': column,'data' : data}
            // console.log(data)
            setState(Adata)
        }
      )
    },[]
  )

  return (
    <MaterialTable
      title="用户表格"
      columns={state.columns}
      data={state.data}
      style={{width:'110%'}}
      editable={{
        onRowAdd: newData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();
              setState(prevState => {
                const data = [...prevState.data];
                // console.log(newData)
                if(newData.idBuyer==null)
                  newData.idBuyer="未设置"
                if(newData.buyerEmail==null)
                  newData.buyerEmail="未设置"
                if(newData.buyerHeadpor==null)
                  newData.buyerHeadpor="未设置"
                if(newData.buyerName==null)
                  newData.buyerName="未设置"
                if(newData.buyerNumber==null)
                  newData.buyerNumber="未设置"
                if(newData.buyerPassword==null)
                  newData.buyerPassword="未设置"
                if(newData.buyerTel==null)
                  newData.buyerTel="未设置"
                  var query = JSON.stringify(newData)
                  query = JSON.parse(query)
                  delete query.tableData
                //此处返回query
                
                console.log(query)
                data.push(newData);
                return { ...prevState, data };
              });
            }, 600);
          }),
        onRowUpdate: (newData, oldData) =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();
              if (oldData) {
                setState(prevState => {
                  const data = [...prevState.data];
                  // console.log(data)
                  data[data.indexOf(oldData)] = newData;
                  // console.log(newData)
                  var query = JSON.stringify(newData)
                  query = JSON.parse(query)
                  delete query.tableData
                  //此处写返回query

                  console.log(query)
                  return { ...prevState, data };
                });
              }
            }, 600);
          }),
        onRowDelete: oldData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();
              setState(prevState => {
                const data = [...prevState.data];
                // console.log(data)
                data.splice(data.indexOf(oldData), 1);
                // console.log(oldData)
                var query = JSON.stringify(oldData)
                query = JSON.parse(query)
                delete query.tableData
                //此处返回query

                console.log(query)
                return { ...prevState, data };
              });
            }, 600);
          }),
      }}
    />
  );
}