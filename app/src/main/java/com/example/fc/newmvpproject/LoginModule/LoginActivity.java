package com.example.fc.newmvpproject.LoginModule;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.fc.newmvpproject.LoginModule.Model.LoginResult;
import com.example.fc.newmvpproject.LoginModule.Presenter.LoginPresenterCompl;
import com.example.fc.newmvpproject.LoginModule.View.ILoginView;
import com.example.fc.newmvpproject.R;
import com.example.fc.newmvpproject.TabPageModule.TabActivity;
import com.example.fc.newmvpproject.Utils.ToastUtil;
import com.fc.myutilmodule.Anim.JellyInterpolator;
import com.fc.myutilmodule.BaseModule.BaseActivity;
import com.fc.myutilmodule.RxJavaModule.RxJavaUtils;
import com.fc.myutilmodule.ViewModule.BamButton;
import com.fc.myutilmodule.ViewModule.BamTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.login_main_logoImg)
    ImageView loginMainLogoImg;
    @BindView(R.id.login_main_accout)
    EditText loginMainAccout;
    @BindView(R.id.login_main_password)
    EditText loginMainPassword;
    @BindView(R.id.login_psw_showPsw)
    ImageView loginPswShowPsw;
    @BindView(R.id.login_psw_layout)
    LinearLayout loginPswLayout;
    @BindView(R.id.login_main_unlock)
    BamTextView loginMainUnlock;
    @BindView(R.id.login_main_forget)
    BamTextView loginMainForget;


    @BindView(R.id.login_main_submit)
    BamButton loginMainSubmit;
    @BindView(R.id.login_main_register)
    BamTextView loginMainRegister;
    @BindView(R.id.rootViews)
    RelativeLayout rootViews;

    @BindView(R.id.layout_progress)
    View progress;
    @BindView(R.id.login_show_btn)
    CheckBox loginShowBtn;


    private float mWidth, mHeight;

    LoginPresenterCompl loginPresenterCompl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenterCompl = new LoginPresenterCompl(this);

        RxJavaUtils.RxCheckChange(loginShowBtn, new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if(aBoolean) {
                    loginMainSubmit.setVisibility(View.VISIBLE);
                }else{
                    loginMainSubmit.setVisibility(View.GONE);
                }
            }
        });

        RxJavaUtils.RxClick(loginMainSubmit, new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                ClickLogin();
                loginPresenterCompl.doLogin("123", "123");
            }
        });
    }


    private void ClickLogin() {
        mWidth = loginMainSubmit.getMeasuredWidth();
        mHeight = loginMainSubmit.getMeasuredHeight();
        loginMainSubmit.setVisibility(View.VISIBLE);
        inputAnimator(loginMainSubmit, mWidth, mHeight);
    }



    @OnClick({R.id.login_main_forget, R.id.login_main_register})
    public void onViewClicked(final View view) {
        switch (view.getId()) {
            case R.id.login_main_forget:
                loginPresenterCompl.getUserInfo();
                break;
            case R.id.login_main_register:
                loginPresenterCompl.doLoginFielMap("333", "444");
                break;

        }
    }


    @Override
    public void cleanContent() {
        loginPresenterCompl.CleanPsw();
    }

    @Override
    public void LoginResult(LoginResult result) {

        if (result != null) {
            recovery();
            Log.d("test", result.getName());
            ToastUtil.showText(result.getName());
            IntentToActivity(LoginActivity.this, TabActivity.class, null);
            finish();
        } else {
            recovery();
        }
//        if(result.getCode()== 400){
//            recovery();
//        }else{
//            recovery();
//            IntentToActivity(LoginActivity.this, TabActivity.class,null);
//            finish();
//        }

    }

    //--------------------------------------动画效果----------------------------------------------
    private void inputAnimator(final View view, float w, float h) {
        AnimatorSet set = new AnimatorSet();
        ValueAnimator animator = ValueAnimator.ofFloat(0, w);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view
                        .getLayoutParams();
                params.leftMargin = (int) value;
                params.rightMargin = (int) value;
                view.setLayoutParams(params);
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(loginMainSubmit,
                "scaleX", 1f, 0.5f);
        set.setDuration(200);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(animator, animator2);
        set.start();
        set.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                progress.setVisibility(View.VISIBLE);
                progressAnimator(progress);
                loginMainSubmit.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // TODO Auto-generated method stub

            }
        });

    }

    private void progressAnimator(final View view) {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
                0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
                0.5f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view,
                animator, animator2);
        animator3.setDuration(200);
        animator3.setInterpolator(new JellyInterpolator());
        animator3.start();

    }

    /**
     * 恢复初始状态
     */
    private void recovery() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.GONE);
                loginMainSubmit.setVisibility(View.VISIBLE);
//        mName.setVisibility(View.VISIBLE);
//        mPsw.setVisibility(View.VISIBLE);
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) loginMainSubmit.getLayoutParams();
                params.leftMargin = 0;
                params.rightMargin = 0;
                loginMainSubmit.setLayoutParams(params);


                ObjectAnimator animator2 = ObjectAnimator.ofFloat(loginMainSubmit, "scaleX", 0.5f, 1f);
                animator2.setDuration(200);
                animator2.setInterpolator(new AccelerateDecelerateInterpolator());
                animator2.start();
            }
        }, 2000);

    }


}
