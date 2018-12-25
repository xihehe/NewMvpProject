package com.example.fc.newmvpproject.TestModule.NetworkModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestRequest;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Model.TestResult;
import com.example.fc.newmvpproject.TestModule.NetworkModule.Presenter.NetWorkPresenterCompl;
import com.example.fc.newmvpproject.TestModule.NetworkModule.View.ITestNetWork;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.BaseModule.BaseToolBarActivity;
import com.fc.myutilmodule.ViewModule.BamButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestNetWorkActivity extends BaseToolBarActivity implements ITestNetWork {

    @BindView(R.id.network_ob_noparm)
    BamButton networkObNoparm;
    @BindView(R.id.network_ob_param)
    BamButton networkObParam;
    @BindView(R.id.network_ob_object)
    BamButton networkObObject;
    @BindView(R.id.network_ob_requestBody)
    BamButton networkObRequestBody;
    @BindView(R.id.network_ob_fielmap)
    BamButton networkObFielmap;

    NetWorkPresenterCompl netWorkPresenterCompl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_network);
        ButterKnife.bind(this);
        netWorkPresenterCompl = new NetWorkPresenterCompl(this);

    }

    @Override
    public void Request_Result(TestResult testResult) {
        dialogPresenterCompl.dissProgressDialog();
        if(testResult!=null){
            ToastUtil.showText(testResult.getName());
        }
    }
    @Override
    public void Request_fail(String failmsg) {
        dialogPresenterCompl.dissProgressDialog();
        ToastUtil.showText(failmsg);
    }

    @OnClick({R.id.network_ob_noparm, R.id.network_ob_param, R.id.network_ob_object, R.id.network_ob_requestBody, R.id.network_ob_fielmap})
    public void onViewClicked(View view) {
        dialogPresenterCompl.setProgressDialogTxt("数据加载中...");
        TestRequest testRequest = new TestRequest();
        testRequest.setUserName("测试");
        testRequest.setUserPhone("12312312323");
        testRequest.setUserPsw("qaz123456789");
        switch (view.getId()) {
            case R.id.network_ob_noparm:
                netWorkPresenterCompl.RequestGetUserInfo();
                break;
            case R.id.network_ob_param:
                netWorkPresenterCompl.RequestOB(testRequest);
                break;
            case R.id.network_ob_object:
                netWorkPresenterCompl.RequestOBObject(testRequest);
                break;
            case R.id.network_ob_requestBody:
                netWorkPresenterCompl.RequestOBRequestBody(testRequest);
                break;
            case R.id.network_ob_fielmap:
                netWorkPresenterCompl.RequestOBFielMap(testRequest);
                break;
        }
    }
}
