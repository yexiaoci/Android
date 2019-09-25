package com.example.helloworld.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.helloworld.R;
import com.example.helloworld.adapter.ExerciseAdapter;
import com.example.helloworld.entity.Exercise;
import com.example.helloworld.utils.IOUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class ExerciseFragment extends Fragment {
    private static final String ARG_PARAM = "param";
    private String mParam;
    private OnFragmentInteractionListener mListener;

    private ListView lvExecise;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    public static ExerciseFragment newInstance(String param) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    List<Exercise> exercises;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_execise, container, false);
        // 准备的列表
        initData();

        // 1. 获取列表控件
        lvExecise = view.findViewById(R.id.list_view);
        // 2. 创建集合类控件需要的Adaper数据适配器（作用：UI与ArrayLt数据的桥梁）
//        String[] data = {"软件1711", "软件1721", "软件1731", "软件1741", "软件1751"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                getActivity(), android.R.layout.simple_list_item_1, data);
        ExerciseAdapter adapter = new ExerciseAdapter(getActivity(), exercises);
        // 3. 设置ListView的Adapter
        lvExecise.setAdapter(adapter);

        // 4. ListView中的item的事件监听
        lvExecise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Exercise exercise = (Exercise) parent.getItemAtPosition(position);
//                Intent intent = new Intent(ExerciseFragment.this.getContext(), ExerciseDetailActivity.class);
//                intent.putExtra("id", exercise.getId());
//                intent.putExtra("title", exercise.getTitle());
//                ExerciseFragment.this.startActivity(intent);
            }
        });
        return view;
    }

    private void initData() {
        exercises = new ArrayList<>();

        try {
            // 1. 从assets目录中获取资源的输入流
            InputStream input = getResources().getAssets().open("exercise_title.json");
            // 2. 将inputstream转为String
            String json = IOUtils.convert(input, StandardCharsets.UTF_8);
            // 3. 利用fastjson将字符串转为对象集合
            exercises = JSON.parseArray(json, Exercise.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateData() {
        exercises = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            Exercise exercise = new Exercise();
            exercise.setId(i + 1);
            switch (i) {
                case 0:
                    exercise.setTitle("第1章 Android基础");
                    exercise.setSubTitle("共计5题");
                    break;
                case 1:
                    exercise.setTitle("第2章 自主学习");
                    exercise.setSubTitle("共计5题");

                    break;
                case 2:
                    exercise.setTitle("第3章 Android UI开发");
                    exercise.setSubTitle("共计5题");

                    break;
                case 3:
                    exercise.setTitle("第4章 啦啦啦 ");
                    exercise.setSubTitle("共计5题");
                    break;
                case 4:
                    exercise.setTitle("第5章 JAVA");
                    exercise.setSubTitle("共计5题");
                    break;
                case 5:
                    exercise.setTitle("第6章 数据结构");
                    exercise.setSubTitle("共计5题");
                    break;

                default:
                    break;
            }
            exercises.add(exercise);
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.setToolbarTitle("向Activity传值");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            mListener.setToolbarTitle("向Activity传值");

        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void setToolbarTitle(String title);
    }
}
