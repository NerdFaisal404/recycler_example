package com.faisal.test.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faisal.test.R;
import com.faisal.test.model.Student;

public class StudentAdapter extends BaseAdapter<Student> {

    private Context mContext;
    private ItemClickListener mItemClickListener;

    public StudentAdapter(Context context, ItemClickListener itemClickListener) {
        this.mContext = context;
        this.mItemClickListener = itemClickListener;

    }


    @Override
    public boolean isEqual(Student left, Student right) {
        return left.getName().equals(right.getId());
    }

    @Override
    public BaseViewHolder newViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_student, parent, false);
        return new StudentAdapter.StudentHolder(view);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder<Student> holder, int position) {
        super.onBindViewHolder(holder, position);
        Student currentNeed = getItem(position);
        if (currentNeed == null) return;
        holder.bind(currentNeed);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return 0;
    }

    @Override
    protected Student getObjForPosition(int position) {
        return null;
    }

    private class StudentHolder extends BaseViewHolder<Student> implements View.OnClickListener {

        private TextView textViewid, textViewName, textViewGrade;
        private Button buttonPress;
        private LinearLayout linearLayout;
        private Student mStudent;


        public StudentHolder(View itemView) {
            super(itemView);


            textViewid = (TextView) itemView.findViewById(R.id.id);
            textViewName = (TextView) itemView.findViewById(R.id.name);
            textViewGrade = (TextView) itemView.findViewById(R.id.grade);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);


            buttonPress = (Button) itemView.findViewById(R.id.buttonPress);
            buttonPress.setOnClickListener(this);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void bind(Student student) {

            if (student == null)
                return;
            mStudent = student;

            textViewid.setText(String.valueOf(student.getId()));
            textViewName.setText(student.getName());
            textViewGrade.setText(student.getGrade());

        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.buttonPress) {
                mItemClickListener.onItemClick(view, getItem(getAdapterPosition()));

            }
        }
    }
}
